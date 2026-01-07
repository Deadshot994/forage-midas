package com.jpmc.midascore.service;

import com.jpmc.midascore.entity.TransactionRecord;
import com.jpmc.midascore.entity.UserRecord;
import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.repository.TransactionRecordRepository;
import com.jpmc.midascore.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import com.jpmc.midascore.foundation.Incentive;

import java.util.Optional;

@Service
public class TransactionProcessingService {

    private final UserRepository userRepository;
    private final TransactionRecordRepository transactionRecordRepository;
    private final RestTemplate restTemplate;

    public TransactionProcessingService(UserRepository userRepository,
                                        TransactionRecordRepository transactionRecordRepository,
                                        RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.transactionRecordRepository = transactionRecordRepository;
        this.restTemplate = restTemplate;
    }

    @Transactional
    public void process(Transaction transaction) {

        UserRecord sender = userRepository.findById(transaction.getSenderId());
        UserRecord recipient = userRepository.findById(transaction.getRecipientId());

        // Validate sender and recipient
        if (sender == null || recipient == null) {
            return;
        }

        // Validate balance
        if (sender.getBalance() < transaction.getAmount()) {
            return;
        }

        // Call Incentive API
        Incentive incentive = restTemplate.postForObject(
                "http://localhost:8080/incentive",
                transaction,
                Incentive.class
        );

        float incentiveAmount = (incentive != null) ? incentive.getAmount() : 0.0f;

        // Update balances
        sender.setBalance(sender.getBalance() - transaction.getAmount());
        recipient.setBalance(
                recipient.getBalance()
                        + transaction.getAmount()
                        + incentiveAmount
        );


        // Persist updated users
        userRepository.save(sender);
        userRepository.save(recipient);

        TransactionRecord record =
                new TransactionRecord(
                        sender,
                        recipient,
                        (double) transaction.getAmount(),
                        (double) incentiveAmount
                );


        transactionRecordRepository.save(record);
    }
}

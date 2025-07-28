package com.camphotoapp.stats.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.camphotoapp.common.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;

@Repository
public class CommentRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public CommentRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public void save(Comment comment) {
        dynamoDBMapper.save(comment);
    }

    public List<Comment> findAll() {
        return dynamoDBMapper.scan(Comment.class, new DynamoDBScanExpression());
    }

    public List<Comment> findAllSortedInversely() {
        List<Comment> comments = dynamoDBMapper.scan(Comment.class, new DynamoDBScanExpression());
        return comments.stream()
                .sorted(Comparator.comparing(Comment::getTimestamp).reversed())
                .toList();
    }
}

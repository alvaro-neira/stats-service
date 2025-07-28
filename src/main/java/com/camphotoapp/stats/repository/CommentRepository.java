package com.camphotoapp.stats.repository;

import com.camphotoapp.common.model.Comment;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CommentRepository {

    private final DynamoDbTable<Comment> commentTable;

    public CommentRepository(DynamoDbTable<Comment> commentTable) {
        this.commentTable = commentTable;
    }

    public void save(Comment comment) {
        commentTable.putItem(comment);
    }

    public List<Comment> findAll() {
        return commentTable.scan().items().stream().collect(Collectors.toList());
    }

    public List<Comment> findAllSortedInversely() {
        List<Comment> comments = commentTable.scan().items().stream().collect(Collectors.toList());
        comments.sort(Comparator.comparing(Comment::getTimestamp).reversed());
        return comments;
    }
}

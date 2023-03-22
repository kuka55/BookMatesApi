package com.codecool.bookclub.user.service;

import com.codecool.bookclub.book.model.UserBook;
import com.codecool.bookclub.event.model.Event;
import com.codecool.bookclub.forum.model.Comment;
import com.codecool.bookclub.forum.model.Topic;
import com.codecool.bookclub.user.model.User;
import com.codecool.bookclub.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
@Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public List<UserBook> getUserBooks(long userId){
//        return userRepository.findById(userId).map(user -> user.getBooks()).orElse(null);
//    }

    public Optional<User> getUserById(long userId){
        return userRepository.findById(userId);
    }

    public List<Event> getUserEvents(long userId){
        return getUserById(userId).map(User::getEvents).orElse(null);
    }

    public List<Topic> getUserTopics(long userId){
        return getUserById(userId).map(User::getTopics).orElse(null);
    }

    public List<Comment> getUserComments(long userId){
        return getUserById(userId).map(User::getComments).orElse(null);
    }

    public boolean deleteUserById(long userId){
        return getUserById(userId).map(user -> {
            userRepository.deleteById(userId);
            return true;
        }).orElse(false);
    }

    public void addUser(String username, String password){
        userRepository.save(new User(username, password));
    }


}

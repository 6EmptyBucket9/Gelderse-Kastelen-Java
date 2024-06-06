package com.example.Gelderse_Kastelen_Java.services;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.apache.commons.lang3.StringUtils;

import com.example.Gelderse_Kastelen_Java.models.User;
import com.example.Gelderse_Kastelen_Java.models.UserLoginDTO;
import com.example.Gelderse_Kastelen_Java.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    // Get method
    public Iterable<User> getUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userRepository.findAll();
    }

    // Post method
    public User postUser(User user) {
        try {
            List<User> existingUser = userRepository.findUserByEmail(user.getEmail(), user.getUserId());
            if (!existingUser.isEmpty()) {
                throw new IllegalArgumentException("Account is already made with entered email");
            } else {
                user.setWachtwoord(passwordEncoder(user.getWachtwoord()));
                return userRepository.save(user);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

    }

    // Patch method
    public User patchUser(int id, Map<String, Object> fields) {
        try {
            Optional<User> existingUser = userRepository.findById(id);
            if (existingUser.isPresent()) {
                fields.forEach((key, value) -> { // Map through fields
                    Field field = ReflectionUtils.findField(User.class, key);
                    if ((key.toString() == "naam") && (key.toString() == "rol")
                            && (!StringUtils.isAlphaSpace(value.toString()))) {
                        throw new IllegalArgumentException("Field cannot contain numbers or special characters");
                    } else {
                        if (key.toString() == "wachtwoord") {
                            value = passwordEncoder(value.toString());
                            field.setAccessible(true);
                            ReflectionUtils.setField(field, existingUser.get(), value);
                        } else {
                            field.setAccessible(true);
                            ReflectionUtils.setField(field, existingUser.get(), value);
                        }

                    }
                });
                return userRepository.save(existingUser.get());
            } else {
                throw new IllegalArgumentException("user not found");
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    // Encrypting the password on entry
    private String passwordEncoder(String password) {
        PasswordEncoder passwordEncoder;
        passwordEncoder = new BCryptPasswordEncoder();

        String encodedPassword = passwordEncoder.encode(password);
        return encodedPassword;
    }

    // Map entity to DTO
    private UserLoginDTO mapToDTO(User existingAccount) {
        UserLoginDTO dto = new UserLoginDTO();
        dto.setUserEmail(existingAccount.getEmail());
        dto.setUserName(existingAccount.getNaam() + " " + existingAccount.getAchternaam());
        dto.setUserRole(existingAccount.getRol());
        dto.setUserRang(existingAccount.getRang());
        // Map other attributes
        return dto;
    }

    // Modify the validateUser method to return a DTO
    public UserLoginDTO validateUser(Map<String, Object> fields) {
        try {
            final Object[] loginUsername = { null };
            final Object[] loginPassword = { null };
            fields.forEach((key, value) -> {
                if ("email".equals(key)) {
                    loginUsername[0] = value;
                }
                if ("wachtwoord".equals(key)) {
                    loginPassword[0] = value;
                }
            });

            List<User> existingAccounts = userRepository.validationByEmail(loginUsername[0].toString());

            if (existingAccounts.isEmpty()) {
                return null;
            }

            User existingAccount = existingAccounts.get(0);
            String hashedPassword = existingAccount.getWachtwoord();

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (encoder.matches(loginPassword[0].toString(), hashedPassword)) {
                return mapToDTO(existingAccount);
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

}

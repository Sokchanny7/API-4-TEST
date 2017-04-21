package com.api.repositories;

import com.api.model.User;

public interface UserDetailRepository {
	User findByEmail(String email);
}

package org.waylab.sgy.repositories.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.waylab.sgy.domain.Company;
import org.waylab.sgy.domain.RegisteredUser;
import org.waylab.sgy.repositories.RegisteredUserRepository;


public interface CompanyMongoDbRepository extends RegisteredUserRepository, MongoRepository<Company, String> {
}

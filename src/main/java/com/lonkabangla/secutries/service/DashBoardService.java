package com.lonkabangla.secutries.service;

import com.lonkabangla.secutries.repository.AccountHolderRepo;
import com.lonkabangla.secutries.repository.BOAccountRepoRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashBoardService {

    private final AccountHolderRepo accountHolderRepo;

    private final BOAccountRepoRepo boAccountRepoRepo;

    private final JdbcTemplate jdbcTemplate;

    public DashBoardService(AccountHolderRepo accountHolderRepo, BOAccountRepoRepo boAccountRepoRepo, JdbcTemplate jdbcTemplate) {
        this.accountHolderRepo = accountHolderRepo;
        this.boAccountRepoRepo = boAccountRepoRepo;
        this.jdbcTemplate = jdbcTemplate;
    }

    public Long countmale() {
        return accountHolderRepo.countByGender("male");
    }

    public Long countFemale() {
        return accountHolderRepo.countByGender("Female");
    }

    public Map<String, Long> getDivisionCityCounts() {
        String query = "SELECT city, COUNT(city) as city_count FROM address GROUP BY city";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        Map<String, Long> divisionMap = new HashMap<>();

        for (Map<String, Object> row : rows) {
            String city = (String) row.get("city");
            Long cityCount = (Long) row.get("city_count");
            divisionMap.put(city, cityCount);
        }

        return divisionMap;
    }
}

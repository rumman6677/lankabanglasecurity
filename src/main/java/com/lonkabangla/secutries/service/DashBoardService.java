package com.lonkabangla.secutries.service;

import com.lonkabangla.secutries.repository.AccountHolderRepo;
import com.lonkabangla.secutries.repository.BOAccountRepoRepo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

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

    public Map<String, Long> getUserStatus() {
        String query = "SELECT status , COUNT(status) as status_count FROM account GROUP BY status";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        Map<String, Long> usercount = new HashMap<>();

        for (Map<String, Object> row : rows) {
            String city = (String) row.get("status");
            Long cityCount = (Long) row.get("status_count");
            usercount.put(city, cityCount);
        }

        return usercount;

    }

    public Map<String, Long> getUserPerbranch() {

        String query = "SELECT branch_name_ofl_sl , COUNT(branch_name_ofl_sl) as branch FROM account GROUP BY branch_name_ofl_sl ";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        Map<String, Long> usercount = new HashMap<>();

        for (Map<String, Object> row : rows) {
            String branch = (String) row.get("branch_name_ofl_sl");
            Long count = (Long) row.get("branch");
            usercount.put(branch, count);
        }
        List<String> optionValues = Arrays.asList(
                "Principal", "Chattogram", "Khatungonj", "Banani", "Nasirabad",
                "Uttara", "Sylhet", "Dhanmondi", "Cumilla", "Narayangonj"
        );

        Map<String, Long> finalResult = new HashMap<>();

        for (String option : optionValues) {
            finalResult.put(option, usercount.getOrDefault(option, 0L));
        }
        return finalResult;
    }

    public Map<String, Map<String, Long>> getMaleAndFemale() {

        String query = "SELECT b.branch_name_ofl_sl,SUM(CASE WHEN a.gender = 'male' THEN 1 ELSE 0 END) AS male_count,SUM(CASE WHEN a.gender = 'female' THEN 1 ELSE 0 END) AS female_count" +
                " FROM account b JOIN account_holder a ON a.id = b.account_holder_id" +
                " GROUP BY branch_name_ofl_sl";

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        Map<String, Map<String, Long>> result = new HashMap<>();
        List<String> optionValues = Arrays.asList(
                "Principal", "Chattogram", "Khatungonj", "Banani", "Nasirabad",
                "Uttara", "Sylhet", "Dhanmondi", "Cumilla", "Narayangonj"
        );

        Map<String, Map<String, Long>> userCount = new HashMap<>();
        for (Map<String, Object> row : rows) {
            String branch = (String) row.get("branch_name_ofl_sl");
            BigDecimal maleCountBigDecimal = (BigDecimal) row.get("male_count");
            BigDecimal femaleCountBigDecimal = (BigDecimal) row.get("female_count");

            Long maleCount = maleCountBigDecimal != null ? maleCountBigDecimal.longValue() : 0L;
            Long femaleCount = femaleCountBigDecimal != null ? femaleCountBigDecimal.longValue() : 0L;

            Map<String, Long> genderCounts = new HashMap<>();
            genderCounts.put("Male", maleCount);
            genderCounts.put("Female", femaleCount);

            userCount.put(branch, genderCounts);
        }


        for (String option : optionValues) {
            Map<String, Long> genderCounts = new HashMap<>();
            if (userCount.containsKey(option)) {
                genderCounts.put("Male", userCount.get(option).get("Male"));
                genderCounts.put("Female", userCount.get(option).get("Female"));
            } else {
                genderCounts.put("Male", 0L);
                genderCounts.put("Female", 0L);
            }
            result.put(option, genderCounts);
        }

        return result;
    }

    public Map<Integer, Long> accountPeryesr() {

        String query = "SELECT year, COUNT(year) as year_count FROM account GROUP BY year";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);

        Map<Integer, Long> usercount = new HashMap<>();

        for (Map<String, Object> row : rows) {
            Integer branch = (int) row.get("year");
            Long count = (Long) row.get("year_count");
            usercount.put(branch, count);
        }
        List<Integer> optionValues = Arrays.asList(
                2010, 2011, 2012, 2013, 2014,
                2015, 2016, 2017, 2018, 2019,2020,2021,2022,2023
        );

        Map<Integer, Long> finalResult = new HashMap<>();

        for (Integer option : optionValues) {
            finalResult.put(option, usercount.getOrDefault(option, 0L));
        }
        return finalResult;


    }
}


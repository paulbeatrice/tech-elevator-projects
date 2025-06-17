package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Collection> getCollections() {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id, collection_name FROM collection";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            collections.add(mapRowToCollection(results));
        }
        return collections;
    }

    @Override
    public Collection getCollectionById(int id) {
        String sql = "SELECT collection_id, collection_name FROM collection WHERE collection_id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToCollection(results);
        }
        return null;
    }

    @Override
    public List<Collection> getCollectionsByName(String name, boolean useWildCard) {
        List<Collection> collections = new ArrayList<>();
        String sql;
        SqlRowSet results;

        if (useWildCard) {
            sql = "SELECT collection_id, collection_name FROM collection WHERE collection_name ILIKE ?";
            results = jdbcTemplate.queryForRowSet(sql, "%" + name + "%");
        } else {
            sql = "SELECT collection_id, collection_name FROM collection WHERE collection_name = ?";
            results = jdbcTemplate.queryForRowSet(sql, name);
        }
        while (results.next()) {
            collections.add(mapRowToCollection(results));
        }
        return collections;
    }
    private Collection mapRowToCollection(SqlRowSet rowSet) {
        Collection collection = new Collection();
        collection.setId(rowSet.getInt("collection_id"));
        collection.setName(rowSet.getString("collection_name"));
        return collection;
    }
}

package ele.me.dao;

import com.sun.istack.internal.NotNull;
import ele.me.entity.HistEnv;
import ele.me.entity.HistLog;
import ele.me.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by dd on 16/11/3.
 */
@Component
public class DbAccess {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<HistEnv> loadHistEnv(@NotNull int dayNoStart, @NotNull int dayNoEnd){
        String sql = "select * from his_eco_env where day_no >= ? and day_no <= ? and user_id != 'NULL'";
        return jdbcTemplate.query(sql, new Object[]{dayNoStart, dayNoEnd}, BeanPropertyRowMapper.newInstance(HistEnv.class));
    }

    public HistLog getHistLog(String listId){
        String sql = "select * from his_eco_info where list_id = ?";
        return jdbcTemplate.query(sql, new String[]{listId}, BeanPropertyRowMapper.newInstance(HistLog.class)).get(0);
    }

    public Restaurant getRestaurant(String restaurantId){
        String sql = "select * from rst_info where restaurant_id = ?";
        return jdbcTemplate.queryForObject(sql, new String[]{restaurantId}, BeanPropertyRowMapper.newInstance(Restaurant.class));
    }


    public List<String> getPredBuyLog(String userId) {
        String sql = "select log_id from predict_data where is_buy = 1 and user_id = ?";
        return jdbcTemplate.queryForList(sql, new String[]{userId}, String.class);
    }

    public List<String> getRealBuyLog(String userId) {
        String sql = "select log_id from combine_data where is_buy = 1 and user_id = ?";
        return jdbcTemplate.queryForList(sql, new String[]{userId}, String.class);
    }

    public int getLogCount(String userId) {
        String sql = "select count(DISTINCT log_id) from predict_data where user_id = ?";
        return jdbcTemplate.queryForObject(sql, new String[]{userId}, Integer.class);
    }

    public List<String> getPredClickLog(String userId) {
        String sql = "select log_id from predict_data where is_click = 1 and user_id = ?";
        return jdbcTemplate.queryForList(sql, new String[]{userId}, String.class);
    }

    public List<String> getRealClickLog(String userId) {
        String sql = "select log_id from combine_data where is_click = 1 and user_id = ?";
        return jdbcTemplate.queryForList(sql, new String[]{userId}, String.class);
    }

    public List<String> getPredUserIds() {
        String sql = "select DISTINCT user_id from predict_data where user_id != 'NULL'";
        return jdbcTemplate.queryForList(sql, new String[]{}, String.class);
    }
}

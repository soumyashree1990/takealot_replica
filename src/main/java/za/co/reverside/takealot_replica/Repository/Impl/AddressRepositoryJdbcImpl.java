package za.co.reverside.takealot_replica.Repository.Impl;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import za.co.reverside.takealot_replica.Model.AddressForm;
import za.co.reverside.takealot_replica.Repository.AddressRepository;
import za.co.reverside.takealot_replica.Util.AddressMapper;

import javax.sql.DataSource;

@Repository
public class AddressRepositoryJdbcImpl implements AddressRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
                dataSource);
    }

    @Override
    public void saveAddress(AddressForm address) {
        String sql = "insert into address (Address_Id,Address_1, Address_2,City,Zip,State,FullName) "
                + "VALUES(:addressId,:address1,:address2,:city,:zipCode,:state,:fullName)";

        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(
                address);
        namedParameterJdbcTemplate.update(sql, sqlParameterSource);
    }

    @Override
    public AddressForm readAddressById(Long addressId) {
        String sql = "SELECT * FROM address a where a.Address_Id=:addressId";
        SqlParameterSource sqlParameterSource = new MapSqlParameterSource(
                "addressId", addressId);
        return namedParameterJdbcTemplate.queryForObject(sql,
                sqlParameterSource, new AddressMapper());
    }

}
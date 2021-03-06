package za.co.reverside.takealot_replica.Util;

import org.springframework.jdbc.core.RowMapper;
import za.co.reverside.takealot_replica.Model.AddressForm;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper<AddressForm> {

    @Override
    public AddressForm mapRow(ResultSet rs, int rowNum) throws SQLException {
        AddressForm address = new AddressForm();
        address.setAddressId(rs.getLong("Address_Id"));
        address.setAddress1(rs.getString("Address_1"));
        address.setAddress2(rs.getString("Address_2"));
        address.setCity(rs.getString("City"));
        address.setZipCode(rs.getString("Zip"));
        address.setState(rs.getString("State"));
        address.setFullName(rs.getString("FullName"));
        return address;
    }

}
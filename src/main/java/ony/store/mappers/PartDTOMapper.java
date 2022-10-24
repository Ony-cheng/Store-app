package ony.store.mappers;

import ony.store.dto.Part;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PartDTOMapper implements RowMapper<Part> {

    @Override
    public Part mapRow(ResultSet rs, int rowNum) throws SQLException {
        Part part = new Part();
        part.setId(rs.getInt("Id"));
        part.setName(rs.getString("name"));
        part.setPartNumber(rs.getString("partnumber"));
        part.setDescription(rs.getString("description"));
        part.setImageURL(rs.getString("image_url"));
        part.setPrice(rs.getInt("price"));
        return part;
    }
}

package pl.infoshare.junit5._4_security.config;

import org.springframework.stereotype.Component;
import pl.infoshare.junit5._4_security.CurrendaUser;

import java.util.Map;

@Component
public class CurrendaUserRepository {

    private final Map<Integer, CurrendaUser> users = Map.of(
            1, new CurrendaUser("Maciek", 1234),
            2, new CurrendaUser("Anastazja", 9876)
    );

    public CurrendaUser findById(Integer id) {
        return users.get(id);
    }
}

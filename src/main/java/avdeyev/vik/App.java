package avdeyev.vik;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public class App {
    public static void main(String[] args) {
        PlayerDao playerDao = new PlayerDao();
        Optional<Player> playerOptional = playerDao.findById(1L);
        playerOptional.ifPresent(System.out::println);


//        PlayerDao.save(new Player(1, "Alex", "Morozov", LocalDate.now()));
//        PlayerDao.delete(new Player(13L, "Alex", "Morozov", LocalDate.now()));
        List<Player> listAll = PlayerDao.findAll();
        System.out.println(listAll);

        List<Player> listAllGreater = PlayerDao.findAllByBirthDateGreater(LocalDate.of(1900,01,01));
        System.out.println(listAllGreater);
    }
}

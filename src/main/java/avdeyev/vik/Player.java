package avdeyev.vik;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity //Аннотация отвечающая за то что этот класс будет использоваться в маппинге с базой данных через Hibernate
@Table(name = "players") // название таблицы в базе данных

public class Player {


    @Id // поле которое отвечает что оно будет Primary key
    private long id;
    private String name;
    private String surname;
    @Column(name = "birth_date")
    // ставим эту аннотацию, когда поле birthDate не совпадает по названию с названием колонки в таблице базы данных
    private LocalDate birthDate;

    public Player() {

    }

    public Player(long id, String name, String surname, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
    }
}

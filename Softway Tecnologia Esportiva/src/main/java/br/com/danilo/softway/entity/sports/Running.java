package br.com.danilo.softway.entity.sports;

import br.com.danilo.softway.entity.Athlete;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Table(name = "running")
@Entity
public class Running {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idRunning;

    private Double distance;

    @Column(name = "time_running")
    private Date timeRunning = Calendar.getInstance().getTime();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
    String timeString = simpleDateFormat.format(timeRunning);

    private Date dateRunning = Calendar.getInstance().getTime();
    SimpleDateFormat simpleDateFormatDate = new SimpleDateFormat("dd/MM/yyyy");
    String dateString = simpleDateFormatDate.format(dateRunning);

    @Column(name = "localizacao")
    private String location;

    private String feedback;
    private Athlete athleteRunning;

}

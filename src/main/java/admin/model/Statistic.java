package admin.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Dmitry on 06.02.2018.
 */

@Entity
@Table(name = "statistic")
public class Statistic {
    @Id
    @GeneratedValue
    @Column(name = "statisticId", nullable = false)
    private int statisticId;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "correct")
    private boolean correct;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", nullable = false)
    private User user;

}

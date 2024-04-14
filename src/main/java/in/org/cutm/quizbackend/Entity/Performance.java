package in.org.cutm.quizbackend.Entity;
import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Performance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,unique = true)
    private long uid;

    @Column(nullable = false)
    private int Ctech;

    @Column(nullable = false)
    private int Cpptech;

    @Column(nullable = false)
    private int Cshtech;

    @Column(nullable = false)
    private int Javatech;

    @Column(nullable = false)
    private int Dotnettech;

    @Column(nullable = false)
    private int Pythontech;

    @Column(nullable = false)
    private int JStech;

    @Column(nullable = false)
    private int Reacttech;

    @Column(nullable = false)
    private int Angulartech;

    @Column(nullable = false)
    private int Rusttech;

    @Column(nullable = false)
    private int Kotlintech;

    @Column(nullable = false)
    private int ExJStech;

}

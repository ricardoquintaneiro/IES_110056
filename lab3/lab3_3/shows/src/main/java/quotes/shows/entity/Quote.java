package quotes.shows.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quotes")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Movie.class)
    @JoinColumns({ @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            @JoinColumn(name = "title", referencedColumnName = "title"),
            @JoinColumn(name = "year", referencedColumnName = "year") })
    private Movie movie;
    @Column(nullable = false)
    private String quote;
}

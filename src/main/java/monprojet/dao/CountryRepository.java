package monprojet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import monprojet.entity.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// This will be AUTO IMPLEMENTED by Spring
//

public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query("SELECT SUM(c.population) from City c where c.country.id = :countryID")
    Integer calculerPopulation(Integer countryID);

    @Query(value = "SELECT co.id as id, SUM(population) as population " +
            "FROM Country co " +
            "INNER JOIN City ci ON co.id = ci.country_id " +
            "GROUP BY id"
            )

}


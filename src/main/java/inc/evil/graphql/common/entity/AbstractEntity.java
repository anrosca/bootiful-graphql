package inc.evil.graphql.common.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractEntity {
    @Id
    @GenericGenerator(name = "uuid-generator", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid-generator")
    protected String id;

    protected AbstractEntity() {
    }

    public String getId() {
        return id;
    }

    public boolean equals(Object other) {
        if (!(other instanceof AbstractEntity otherEntity)) {
            return false;
        }
        return getId().equals(otherEntity.getId());
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "AbstractEntity{" +
                "id='" + id + '\'' +
                '}';
    }
}

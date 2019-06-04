package k300.com.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;

@Entity
@Table(name = "room_type")
public class RoomType {

	public RoomType() {
	}

	public RoomType(String description, Integer maxCapacity) {
		this.description = description;
		this.maxCapacity = maxCapacity;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "description")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String description;

	@Column(name = "max_capacity")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer maxCapacity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMaxCapacity() {
		return maxCapacity;
	}

	public void setMaxCapacity(Integer maxCapacity) {
		this.maxCapacity = maxCapacity;
	}

}

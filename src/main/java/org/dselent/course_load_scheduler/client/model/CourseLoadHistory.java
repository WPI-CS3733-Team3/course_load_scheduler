package org.dselent.course_load_scheduler.client.model;

import java.sql.Timestamp;
import java.time.Instant;

public class CourseLoadHistory extends Model{
	// attributes
	
	private Integer id;
	private Integer courseLoadTypeID;
	private Integer courseLoadHours;
	private Integer facultyID;;
	private Instant createdAt;
	private Instant updatedAt;
	private Boolean deleted;

	//getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCourseLoadTypeID() {
		return courseLoadTypeID;
	}

	public void setCourseLoadTypeID(Integer courseLoadTypeID) {
		this.courseLoadTypeID = courseLoadTypeID;
	}

	public Integer getCourseLoadHours() {
		return courseLoadHours;
	}

	public void setCourseLoadHours(Integer courseLoadHours) {
		this.courseLoadHours = courseLoadHours;
	}

	public Integer getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(Integer facultyID) {
		this.facultyID = facultyID;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}
	
	public void setCreatedAt(Timestamp createdAt)
	{
		if(createdAt != null)
		{
			this.createdAt = createdAt.toInstant();
		}
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public void setUpdatedAt(Timestamp updatedAt)
	{
		if(updatedAt != null)
		{
			this.updatedAt = updatedAt.toInstant();
		}
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	
	//hashCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseLoadHours == null) ? 0 : courseLoadHours.hashCode());
		result = prime * result + ((courseLoadTypeID == null) ? 0 : courseLoadTypeID.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
		result = prime * result + ((facultyID == null) ? 0 : facultyID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof CourseLoadHistory)) {
			return false;
		}
		CourseLoadHistory other = (CourseLoadHistory) obj;
		if (courseLoadHours == null) {
			if (other.courseLoadHours != null) {
				return false;
			}
		} else if (!courseLoadHours.equals(other.courseLoadHours)) {
			return false;
		}
		if (courseLoadTypeID == null) {
			if (other.courseLoadTypeID != null) {
				return false;
			}
		} else if (!courseLoadTypeID.equals(other.courseLoadTypeID)) {
			return false;
		}
		if (createdAt == null) {
			if (other.createdAt != null) {
				return false;
			}
		} else if (!createdAt.equals(other.createdAt)) {
			return false;
		}
		if (deleted == null) {
			if (other.deleted != null) {
				return false;
			}
		} else if (!deleted.equals(other.deleted)) {
			return false;
		}
		if (facultyID == null) {
			if (other.facultyID != null) {
				return false;
			}
		} else if (!facultyID.equals(other.facultyID)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (updatedAt == null) {
			if (other.updatedAt != null) {
				return false;
			}
		} else if (!updatedAt.equals(other.updatedAt)) {
			return false;
		}
		return true;
	}

	//toString
	@Override
	public String toString() {
		return "CourseLoadHistory [id=" + id + ", courseLoadTypeID=" + courseLoadTypeID + ", courseLoadHours="
				+ courseLoadHours + ", facultyID=" + facultyID + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", deleted=" + deleted + "]";
	}
}

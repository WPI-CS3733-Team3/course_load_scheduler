package org.dselent.course_load_scheduler.client.model;

import java.sql.Timestamp;
import java.time.Instant;

public class Schedule extends Model
{
	// attributes
	
	private Integer id;
	private Integer facultyID;
	private Integer sectionsID;
	private Instant createdAt;
	private Instant updatedAt;
	private Boolean deleted;

	//
	public Integer getID() {
		return id;
	}

	public void setID(Integer id) {
		this.id = id;
	}

	public Integer getFacultyID() {
		return facultyID;
	}

	public void setFacultyID(Integer facultyID) {
		this.facultyID = facultyID;
	}

	public Integer getSectionsID() {
		return sectionsID;
	}

	public void setSectionsID(Integer sectionsID) {
		this.sectionsID = sectionsID;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Instant getCreatedAt()
	{
		return createdAt;
	}
	
	public void setCreatedAt(Instant createdAt)
	{
		this.createdAt = createdAt;
	}
	
	public void setCreatedAt(Timestamp createdAt)
	{
		if(createdAt != null)
		{
			this.createdAt = createdAt.toInstant();
		}
	}

	public Instant getUpdatedAt()
	{
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt)
	{
		this.updatedAt = updatedAt;
	}
	
	public void setUpdatedAt(Timestamp updatedAt)
	{
		if(updatedAt != null)
		{
			this.updatedAt = updatedAt.toInstant();
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((deleted == null) ? 0 : deleted.hashCode());
		result = prime * result + ((facultyID == null) ? 0 : facultyID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sectionsID == null) ? 0 : sectionsID.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Schedule other = (Schedule) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (deleted == null) {
			if (other.deleted != null)
				return false;
		} else if (!deleted.equals(other.deleted))
			return false;
		if (facultyID == null) {
			if (other.facultyID != null)
				return false;
		} else if (!facultyID.equals(other.facultyID))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sectionsID == null) {
			if (other.sectionsID != null)
				return false;
		} else if (!sectionsID.equals(other.sectionsID))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Schedule [id=" + id + ", facultyID=" + facultyID + ", sectionsID=" + sectionsID + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", deleted=" + deleted + "]";
	}
}

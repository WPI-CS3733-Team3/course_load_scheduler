package org.dselent.course_load_scheduler.client.model;

import java.sql.Time;

public class CourseSections {
		// attributes
		private String termsName;
		private String sectionType;
		private String sectionsName;
		private String days;
		private String coursesNumber;
		private String coursesTitle;
		private Time startTime;
		private Time endTime;
		private Integer sectionId;
		private Integer sectionTypeId;
		private Integer daysId;
		private Integer startTimeId;
		private Integer endTimeId;
		private Integer coursesId;

		//Setters and Getters
		public Integer getSectionId() {
			return sectionId;
		}

		public void setSectionId(Integer sectionId) {
			this.sectionId = sectionId;
		}

		public Integer getSectionTypeId() {
			return sectionTypeId;
		}

		public void setSectionTypeId(Integer sectionTypeId) {
			this.sectionTypeId = sectionTypeId;
		}

		public Integer getDaysId() {
			return daysId;
		}

		public void setDaysId(Integer daysId) {
			this.daysId = daysId;
		}

		public Integer getStartTimeId() {
			return startTimeId;
		}

		public void setStartTimeId(Integer startTimeId) {
			this.startTimeId = startTimeId;
		}

		public Integer getEndTimeId() {
			return endTimeId;
		}

		public void setEndTimeId(Integer endTimeId) {
			this.endTimeId = endTimeId;
		}

		public Integer getCoursesId() {
			return coursesId;
		}

		public void setCoursesId(Integer coursesId) {
			this.coursesId = coursesId;
		}

		public String getTermsName() {
			return termsName;
		}

		public void setTermsName(String termsName) {
			this.termsName = termsName;
		}
		
		public String getSectionType() {
			return sectionType;
		}

		public void setSectionType(String sectionType) {
			this.sectionType = sectionType;
		}

		public String getSectionsName() {
			return sectionsName;
		}

		public void setSectionsName(String sectionsName) {
			this.sectionsName = sectionsName;
		}

		public String getDays() {
			return days;
		}

		public void setDays(String days) {
			this.days = days;
		}

		public String getCoursesNumber() {
			return coursesNumber;
		}

		public void setCoursesNumber(String coursesNumber) {
			this.coursesNumber = coursesNumber;
		}

		public String getCoursesTitle() {
			return coursesTitle;
		}

		public void setCoursesTitle(String coursesTitle) {
			this.coursesTitle = coursesTitle;
		}

		public Time getStartTime() {
			return startTime;
		}

		public void setStartTime(Time startTime) {
			this.startTime = startTime;
		}

		public Time getEndTime() {
			return endTime;
		}

		public void setEndTime(Time endTime) {
			this.endTime = endTime;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((coursesId == null) ? 0 : coursesId.hashCode());
			result = prime * result + ((coursesNumber == null) ? 0 : coursesNumber.hashCode());
			result = prime * result + ((coursesTitle == null) ? 0 : coursesTitle.hashCode());
			result = prime * result + ((days == null) ? 0 : days.hashCode());
			result = prime * result + ((daysId == null) ? 0 : daysId.hashCode());
			result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
			result = prime * result + ((endTimeId == null) ? 0 : endTimeId.hashCode());
			result = prime * result + ((sectionId == null) ? 0 : sectionId.hashCode());
			result = prime * result + ((sectionType == null) ? 0 : sectionType.hashCode());
			result = prime * result + ((sectionTypeId == null) ? 0 : sectionTypeId.hashCode());
			result = prime * result + ((sectionsName == null) ? 0 : sectionsName.hashCode());
			result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
			result = prime * result + ((startTimeId == null) ? 0 : startTimeId.hashCode());
			result = prime * result + ((termsName == null) ? 0 : termsName.hashCode());
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
			if (!(obj instanceof CourseSections)) {
				return false;
			}
			CourseSections other = (CourseSections) obj;
			if (coursesId == null) {
				if (other.coursesId != null) {
					return false;
				}
			} else if (!coursesId.equals(other.coursesId)) {
				return false;
			}
			if (coursesNumber == null) {
				if (other.coursesNumber != null) {
					return false;
				}
			} else if (!coursesNumber.equals(other.coursesNumber)) {
				return false;
			}
			if (coursesTitle == null) {
				if (other.coursesTitle != null) {
					return false;
				}
			} else if (!coursesTitle.equals(other.coursesTitle)) {
				return false;
			}
			if (days == null) {
				if (other.days != null) {
					return false;
				}
			} else if (!days.equals(other.days)) {
				return false;
			}
			if (daysId == null) {
				if (other.daysId != null) {
					return false;
				}
			} else if (!daysId.equals(other.daysId)) {
				return false;
			}
			if (endTime == null) {
				if (other.endTime != null) {
					return false;
				}
			} else if (!endTime.equals(other.endTime)) {
				return false;
			}
			if (endTimeId == null) {
				if (other.endTimeId != null) {
					return false;
				}
			} else if (!endTimeId.equals(other.endTimeId)) {
				return false;
			}
			if (sectionId == null) {
				if (other.sectionId != null) {
					return false;
				}
			} else if (!sectionId.equals(other.sectionId)) {
				return false;
			}
			if (sectionType == null) {
				if (other.sectionType != null) {
					return false;
				}
			} else if (!sectionType.equals(other.sectionType)) {
				return false;
			}
			if (sectionTypeId == null) {
				if (other.sectionTypeId != null) {
					return false;
				}
			} else if (!sectionTypeId.equals(other.sectionTypeId)) {
				return false;
			}
			if (sectionsName == null) {
				if (other.sectionsName != null) {
					return false;
				}
			} else if (!sectionsName.equals(other.sectionsName)) {
				return false;
			}
			if (startTime == null) {
				if (other.startTime != null) {
					return false;
				}
			} else if (!startTime.equals(other.startTime)) {
				return false;
			}
			if (startTimeId == null) {
				if (other.startTimeId != null) {
					return false;
				}
			} else if (!startTimeId.equals(other.startTimeId)) {
				return false;
			}
			if (termsName == null) {
				if (other.termsName != null) {
					return false;
				}
			} else if (!termsName.equals(other.termsName)) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "CourseSections [termsName=" + termsName + ", sectionType=" + sectionType + ", sectionsName="
					+ sectionsName + ", days=" + days + ", coursesNumber=" + coursesNumber + ", coursesTitle="
					+ coursesTitle + ", startTime=" + startTime + ", endTime=" + endTime + ", sectionId=" + sectionId
					+ ", sectionTypeId=" + sectionTypeId + ", daysId=" + daysId + ", startTimeId=" + startTimeId
					+ ", endTimeId=" + endTimeId + ", coursesId=" + coursesId + "]";
		}
}

package net.socialhub.twitter.web.entity.response;

import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("birthdate")
    private BirthDate birthdate;

    // region
    public BirthDate getBirthdate() {
        return birthdate;
    }
    // endregionF

    public static class BirthDate{

        @SerializedName("day")
        private Integer day;
        @SerializedName("month")
        private Integer month;
        @SerializedName("year")
        private Integer year;

        @SerializedName("visibility")
        private String visibility;
        @SerializedName("year_visibility")
        private String yearVisibility;

        // region
        public Integer getDay() {
            return day;
        }

        public Integer getMonth() {
            return month;
        }

        public Integer getYear() {
            return year;
        }

        public String getVisibility() {
            return visibility;
        }

        public String getYearVisibility() {
            return yearVisibility;
        }
        // endregion
    }
}

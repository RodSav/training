public class UserAddress {
    private final String country;
    private final String title;
    private final String firstName;
    private final String lastName;
    private final String address1;
    private final String city;
    private final String region;
    private final String postcode;
    private final String phone;

    private UserAddress(UserAddressBuilder builder) {
        this.country = builder.country;
        this.title = builder.title;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.address1 = builder.address1;
        this.city = builder.city;
        this.region = builder.region;
        this.postcode = builder.postcode;
        this.phone = builder.phone;
    }

    public String getCountry() {
        return country;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress1() {
        return address1;
    }

    public String getCity() {
        return city;
    }

    public String getRegion() {
        return region;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getPhone() {
        return phone;
    }

    public static class UserAddressBuilder {
        private String country;
        private String title;
        private String firstName;
        private String lastName;
        private String address1;
        private String city;
        private String region;
        private String postcode;
        private String phone;

        public  UserAddressBuilder()
        {
            this.country = country;
            this.title = title;
            this.firstName = firstName;
            this.lastName = lastName;
            this.address1 = address1;
            this.city = city;
            this.region = region;
            this.postcode = postcode;
            this.phone = phone;
        }

        public UserAddressBuilder country(String country) {
            this.country = country;
            return this;
        }

        public UserAddressBuilder title(String title) {
            this.title = title;
            return this;
        }

        public UserAddressBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserAddressBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserAddressBuilder address1(String address1) {
            this.address1 = address1;
            return this;
        }

        public UserAddressBuilder city(String city) {
            this.city = city;
            return this;
        }

        public UserAddressBuilder region(String region) {
            this.region = region;
            return this;
        }

        public UserAddressBuilder postcode(String postcode) {
            this.postcode = postcode;
            return this;
        }

        public UserAddressBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserAddress build() {
            return new UserAddress(this);
        }
    }
}

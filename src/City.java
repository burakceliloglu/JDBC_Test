public class City
{
    private String city_id;
    private String city;
    private String country_id;
    private String last_update;
    public City (String city_id, String city, String country_id, String last_update)
    {
        this.city_id = city_id;
        this.city = city;
        this.country_id=country_id;
        this.last_update=last_update;
    }
}

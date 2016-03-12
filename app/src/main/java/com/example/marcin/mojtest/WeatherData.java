package com.example.marcin.mojtest;

import java.util.List;

public class WeatherData {
    private Coord coord;
    private Clouds clouds;
    private int cod;
    private String base;
    private String name;
    private Main main;
    private List<Weather> weather;
    private Wind wind;
    private Sys sys;

    public WeatherData(Coord coord, Clouds clouds, int cod, String base, String name, Main main,
                       List<Weather> weather, Wind wind, Sys sys) {
        this.coord = coord;
        this.clouds = clouds;
        this.cod = cod;
        this.base = base;
        this.name = name;
        this.main = main;
        this.weather = weather;
        this.wind = wind;
        this.sys = sys;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Wind getWinds() {
        return wind;
    }

    public void setWinds(Wind winds) {
        this.wind = winds;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int code) {
        this.cod = code;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    class Clouds {
        int all;

        public Clouds(int all) {
            this.all = all;
        }

        public int getClouds() {
            return all;
        }

        public void setClouds(int clouds) {
            this.all = clouds;
        }
    }

    class Main {
        double temp;
        double pressure;
        double temp_min;
        double temp_max;
        int humidity;

        public Main(double temp, double pressure, double temp_min, double temp_max, int humidity) {
            this.temp = temp;
            this.pressure = pressure;
            this.temp_min = temp_min;
            this.temp_max = temp_max;
            this.humidity = humidity;
        }

        public double getTemp() {
            return temp;
        }

        public double getTemp_min() {
            return temp_min;
        }

        public void setTemp_min(double temp_min) {
            this.temp_min = temp_min;
        }

        public double getTemp_max() {
            return temp_max;
        }

        public void setTemp_max(double temp_max) {
            this.temp_max = temp_max;
        }

        public void setTemp(double temp) {
            this.temp = temp;
        }

        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }
    }

    class Wind {
        double speed;
        double deq;

        public Wind(double speed, double deq) {
            this.speed = speed;
            this.deq = deq;
        }

        public double getDeq() {
            return deq;
        }

        public void setDeq(double deq) {
            this.deq = deq;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }
    }

    class Coord {
        double lat;
        double lon;

        public Coord(double lat, double lon) {
            this.lat = lat;
            this.lon = lon;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }
    }

    class Weather {
        private int id;
        String main;
        String description;
        String icon;

        public Weather() {
        }

        public Weather(int id, String main, String description, String icon) {
            this.id = id;
            this.main = main;
            this.description = description;
            this.icon = icon;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }
    }

    class Sys {
        int type;
        int id;
        String country;
        long sunrise;
        long sunset;

        public Sys() {
        }

        public Sys(int type, int id, String country, long sunrise, long sunset) {
            this.type = type;
            this.id = id;
            this.country = country;
            this.sunrise = sunrise;
            this.sunset = sunset;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public long getSunrise() {
            return sunrise;
        }

        public void setSunrise(long sunrise) {
            this.sunrise = sunrise;
        }

        public long getSunset() {
            return sunset;
        }

        public void setSunset(long sunset) {
            this.sunset = sunset;
        }
    }

    public double getLat() {
        return coord.getLat();
    }

    public double getLon() {
        return coord.getLon();
    }

    public double getPressure() {
        return main.getPressure();
    }

    public double getTemp() {
        return main.getTemp();
    }

    public String getCountry() {
        return sys.getCountry();
    }

    public long getSunrise() {
        return sys.getSunrise();
    }

    public long getSunset() {
        return sys.getSunset();
    }
}

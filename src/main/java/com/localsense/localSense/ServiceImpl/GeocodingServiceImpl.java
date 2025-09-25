package com.localsense.localSense.ServiceImpl;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.localsense.localSense.service.GeocodingService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GeocodingServiceImpl implements GeocodingService {
    private static final String NOMINATIM_URL = "https://nominatim.openstreetmap.org/search?q={address}&format=json&limit=1";

    public Coordinates getCoordinatesFromAddress(String address) {
        RestTemplate restTemplate = new RestTemplate();

        NominatimResponse[] response = restTemplate.getForObject(
                NOMINATIM_URL,
                NominatimResponse[].class,
                address
        );

        if (response != null && response.length > 0) {
            double lat = Double.parseDouble(response[0].lat);
            double lon = Double.parseDouble(response[0].lon);
            return new Coordinates(lat, lon);
        }

        throw new RuntimeException("Não foi possível obter coordenadas para o endereço: " + address);
    }

    public record Coordinates(double latitude, double longitude) {}

    @JsonIgnoreProperties(ignoreUnknown = true)
    static class NominatimResponse {
        @JsonProperty("lat")
        public String lat;

        @JsonProperty("lon")
        public String lon;

        @JsonProperty("display_name")
        public String displayName;
    }
}

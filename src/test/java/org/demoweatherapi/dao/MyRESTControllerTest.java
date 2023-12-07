package org.demoweatherapi.dao;

import org.demoweatherapi.controller.MyRESTController;
import org.demoweatherapi.entity.CurrentWeather;
import org.demoweatherapi.model.AverageWeather;
import org.demoweatherapi.model.DateRange;
import org.demoweatherapi.parse.Parsing;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MyRESTControllerTest {

    private DateRange dateRange;

    @Mock
    private Parsing parsing;

    @InjectMocks
    private MyRESTController controller;

    @Test
    public void getCurrentWeather(){
        final CurrentWeather weather = mock(CurrentWeather.class);
        when(parsing.createCurrentWeatherFromJson()).thenReturn(weather);

        final CurrentWeather actual = controller.getCurrentWeather();

        assertNotNull(actual);
        assertEquals(weather, actual);
        verify(parsing).createCurrentWeatherFromJson();
    }

    @BeforeEach
    public void init(){
        final String range = "1111-11-11";
        dateRange = new DateRange(range, range);
    }

    @Test
    public void getAverageDailyInfo(){
        final AverageWeather weather = mock(AverageWeather.class);
        when(parsing.createAverageWeatherFromJson(dateRange.getFrom(),dateRange.getTo()))
                .thenReturn(weather);

        final AverageWeather actual = controller.getAverageDailyInfo(dateRange);

        assertNotNull(actual);
        assertEquals(weather, actual);
        verify(parsing).createAverageWeatherFromJson(dateRange.getFrom(), dateRange.getTo());
    }
}

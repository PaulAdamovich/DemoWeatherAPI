package org.demoweatherapi.dao;

import org.demoweatherapi.entity.CurrentWeather;
import org.demoweatherapi.service.WeatherServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceImplTest {

    private static final long ID = 1L;

    @Mock
    private WeatherRepository repository ;

    @InjectMocks
    private WeatherServiceImpl service;

    @Test
    public void saveWeather_shouldCallRepository(){

        final CurrentWeather weather = mock(CurrentWeather.class);

        service.saveWeather(weather);

        verify(repository).save(weather);
        }

    @Test
    public void getWeather_shouldCallRepository(){

        final CurrentWeather weather = mock(CurrentWeather.class);
        when(repository.findById(ID)).thenReturn(Optional.ofNullable(weather));

        final CurrentWeather actual = service.getWeather(ID);

        assertNotNull(actual);
        assertEquals(weather, actual);
        verify(repository).findById(ID);
    }
}

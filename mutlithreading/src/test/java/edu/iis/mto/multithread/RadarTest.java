package edu.iis.mto.multithread;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.Executor;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;

    @RepeatedTest(100)
    void launchPatriotOnceWhenNoticesAScudMissle() {
        Executor executor = Runnable::run;
        int rocketCount = 1;
        BetterRadar radar = new BetterRadar(batteryMock,executor,rocketCount);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock, Mockito.times(rocketCount)).launchPatriot(enemyMissle);
    }

    @RepeatedTest(100)
    void noRockets() {
        Executor executor = Runnable::run;
        int rocketCount = 0;
        BetterRadar radar = new BetterRadar(batteryMock,executor,rocketCount);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock, Mockito.times(rocketCount)).launchPatriot(enemyMissle);
    }

    @RepeatedTest(100)
    void launchPatriot100TimesWhenNoticesAScudMissle() {
        Executor executor = Runnable::run;
        int rocketCount = 100;
        BetterRadar radar = new BetterRadar(batteryMock,executor,rocketCount);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock, Mockito.times(rocketCount)).launchPatriot(enemyMissle);
    }

}
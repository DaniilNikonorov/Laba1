package sample;

import java.util.ArrayList;
import java.util.List;

public class MatModel {

    public Double victim = 10.0;//величина популяции жертв
    public Double predator = 10.0;//величина популяции хищников
    public Double a= 0.02;//коэффициент рождаемости жертв
    public Double b = 0.01;//коээфициент убийства жертв
    public Double c = 0.02;//коэффициент воспроизводства хищников
    public Double d = 0.09;//коэффициент убыли хищников
    public Double h = 1.0;
    public Double t = 0.0;

    public void process() {
        victim += ((a * victim - b * victim * predator) * h);
        predator += ((c * victim * predator - d * predator) * h);
        if(victim < 0) {
            victim = 0.0;
        }
        if(predator < 0) {
            predator = 0.0;
        }
        t += h;
    }
}

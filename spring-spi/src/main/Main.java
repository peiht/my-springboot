

import org.myspring.SpiService;

import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {

        ServiceLoader<SpiService> serviceLoader = ServiceLoader.load(SpiService.class);
        serviceLoader.forEach(spiService -> System.out.println(spiService.getName()));
    }
}
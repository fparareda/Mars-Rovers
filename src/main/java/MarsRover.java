import com.nasa.port.adapter.InputAdapter;
import com.nasa.port.dto.MarsObstacleDto;
import com.nasa.port.dto.MarsRoverDto;
import com.nasa.port.dto.MarsSurfaceDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarsRover {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        System.out.println("Insert horizontal map size:");
        int sizex = reader.nextInt();
        System.out.println("Insert vertical map size:");
        int sizey = reader.nextInt();

        System.out.println("Insert horizontal initial rover position:");
        int roverx = reader.nextInt();
        System.out.println("Insert vertical initial rover position:");
        int rovery = reader.nextInt();
        System.out.println("Insert initial rover direction:");
        String roverz = reader.next(); //n = north, e = east, w = west, s = south


        List<MarsObstacleDto> obstacles = new ArrayList<>();
        String option = "";
        do {
            System.out.println("Insert the surface obstacles (o = set an obstacle, q = no more obstacles):");
            option = reader.next();
            if (option.equals("q")) {
                break;
            }
            System.out.println("Insert obstacle horizontal position:");
            int obstacleX = reader.nextInt();
            System.out.println("Insert obstacle vertical position:");
            int obstacleY = reader.nextInt();

            obstacles.add(new MarsObstacleDto(obstacleX, obstacleY));
        } while (true);

        MarsSurfaceDto marsSurfaceDto = new MarsSurfaceDto(sizex - 1, sizey - 1, obstacles);
        MarsRoverDto marsRoverDto = new MarsRoverDto(roverz, roverx, rovery);
        InputAdapter inputAdapter = new InputAdapter(marsSurfaceDto, marsRoverDto);

        do {
            System.out.println("Insert command (f = forward, b = backward, l = turn left, r = turn right):");
            String command = reader.next();
            marsRoverDto = inputAdapter.moveMarsRover(command);
            System.out.println(marsRoverDto.toString());
        } while (true);
    }
}

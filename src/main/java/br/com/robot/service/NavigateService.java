package br.com.robot.service;

import br.com.robot.entity.enums.CommandEnum;
import br.com.robot.entity.model.Coordinate;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class NavigateService {

    private void validatePosition(Coordinate coordinate){

    }

    public String execute(String[] commands){
        Coordinate coordinate = new Coordinate();
        Arrays.asList(commands).forEach(command->CommandEnum.valueOf(command).execute(coordinate));
        return coordinate.getPosition();
    }
}

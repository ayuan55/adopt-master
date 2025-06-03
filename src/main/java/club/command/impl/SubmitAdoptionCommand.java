// 提交领养申请命令
package club.command.impl;

import club.pojo.AdoptAnimal;
import club.service.AdoptAnimalService;
import club.command.Command;

public class SubmitAdoptionCommand implements Command {
    private AdoptAnimalService adoptAnimalService;
    private AdoptAnimal adoptAnimal;

    public SubmitAdoptionCommand(AdoptAnimalService adoptAnimalService, AdoptAnimal adoptAnimal) {
        this.adoptAnimalService = adoptAnimalService;
        this.adoptAnimal = adoptAnimal;
    }

    @Override
    public void execute() {
        adoptAnimalService.create(adoptAnimal);
    }
}
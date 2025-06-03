// 创建宠物命令
package club.command.impl;

import club.pojo.Pet;
import club.service.PetService;
import club.command.Command;

public class CreatePetCommand implements Command {
    private PetService petService;
    private Pet pet;

    public CreatePetCommand(PetService petService, Pet pet) {
        this.petService = petService;
        this.pet = pet;
    }

    @Override
    public void execute() {
        petService.add(pet);
    }
}
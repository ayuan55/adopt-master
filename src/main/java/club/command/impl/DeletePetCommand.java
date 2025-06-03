// 删除宠物命令
package club.command.impl;

import club.service.PetService;
import club.command.Command;

public class DeletePetCommand implements Command {
    private PetService petService;
    private Integer petId;

    public DeletePetCommand(PetService petService, Integer petId) {
        this.petService = petService;
        this.petId = petId;
    }

    @Override
    public void execute() {
        petService.del(petId);
    }
}
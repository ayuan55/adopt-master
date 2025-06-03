package club.controller;

import club.command.Command;
import club.command.CommandInvoker;
import club.command.impl.CreatePetCommand;
import club.command.impl.DeletePetCommand;
import club.command.impl.UpdatePetCommand;
import club.pojo.Pet;
import club.service.PetService;
import club.util.Message;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
/**
 * @description:
 * @author: zl
 * @create: 2024/12/1 23:02
 */
@Controller
@RequestMapping("/pet")
public class PetController {

    @Resource
    private PetService petService;

    @RequestMapping("/pets")
    @ResponseBody
    public Message pet(@RequestParam(required = false) String petType, @RequestParam("pn")Integer pageNum){
        Integer pageSize = 3;
        if(pageNum == null){
            pageNum = 1;
        }
        PageInfo<Pet> pets = petService.allPet(petType, pageNum, pageSize);
        return Message.success().add("pageInfo",pets );
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Message findPetById(HttpSession session, Integer id){
        Pet pet = petService.findById(id);
        String pics = pet.getPic();
        session.setAttribute("pet", pet);
        session.setAttribute("pics", pics);
        return Message.success().add("pet", pet);
    }

    @RequestMapping("/create")
    @ResponseBody
    public Message add(Pet pet, MultipartFile file){
        String pic = FileLoad.uploadPetPic(file);
        pet.setPic(pic);
        int add = petService.add(pet);
        if(add>0){
            return Message.success();
        }else{
            return Message.fail();
        }

    }

    @RequestMapping("/update")
    @ResponseBody
    public Message update(Pet pet, MultipartFile file){
        if (file != null && file.getSize() > 0){
            String pic = FileLoad.uploadPetPic(file);
            pet.setPic(pic);
        }
        int update = petService.update(pet);
        if(update>0){
           return Message.success();
        }else{
            return Message.fail();
        }
    }

    @RequestMapping("/delete")
    @ResponseBody
    public Message del(Integer id){
        int del = petService.del(id);
        if(del>0){
            return Message.success();
        }else {
            return Message.fail();
        }
    }




    @RequestMapping("/createWithCommand")
    @ResponseBody
    public Message addWithCommand(Pet pet, MultipartFile file) {
        String pic = FileLoad.uploadPetPic(file);
        pet.setPic(pic);

        CommandInvoker invoker = new CommandInvoker();
        Command createCommand = new CreatePetCommand(petService, pet);
        invoker.setCommand(createCommand);
        invoker.executeCommand();

        return Message.success();
    }


    @RequestMapping("/updateWithCommand")
    @ResponseBody
    public Message updateWithCommand(Pet pet, MultipartFile file) {
        if (file != null && file.getSize() > 0) {
            String pic = FileLoad.uploadPetPic(file);
            pet.setPic(pic);
        }

        // 这里使用命令模式进行更新操作
        CommandInvoker invoker = new CommandInvoker();
        Command updateCommand = new UpdatePetCommand(petService, pet);
        invoker.setCommand(updateCommand);
        invoker.executeCommand();

        return Message.success();
    }

    @RequestMapping("/deleteWithCommand")
    @ResponseBody
    public Message delWithCommand(Integer id) {
        CommandInvoker invoker = new CommandInvoker();
        Command deleteCommand = new DeletePetCommand(petService, id);
        invoker.setCommand(deleteCommand);
        invoker.executeCommand();

        return Message.success();
    }

}

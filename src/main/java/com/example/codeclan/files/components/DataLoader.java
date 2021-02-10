package com.example.codeclan.files.components;

import com.example.codeclan.files.models.File;
import com.example.codeclan.files.models.Folder;
import com.example.codeclan.files.models.User;
import com.example.codeclan.files.repositories.FileRepository;
import com.example.codeclan.files.repositories.FolderRepository;
import com.example.codeclan.files.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) {

        User user1 = new User("Jenny");
        userRepository.save(user1);

        Folder folder1 = new Folder("folder_1", user1);
        folderRepository.save(folder1);

        Folder folder2 = new Folder("folder_2", user1);
        folderRepository.save(folder2);

        File file1 = new File("file_1", "txt", 2, folder1);
        fileRepository.save(file1);

        File file2 = new File("file_2", "mp3", 10, folder1);
        fileRepository.save(file2);

        folder1.addFile(file1);
        folder1.addFile(file2);

        user1.addFolder(folder1);
        user1.addFolder(folder2);

        folderRepository.save(folder1);
        userRepository.save(user1);

    }
}

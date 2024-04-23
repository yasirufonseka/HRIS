package com.hris.HRIS.service;

import com.hris.HRIS.model.AttendanceModel;
import com.hris.HRIS.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public AttendanceModel createAttendance(AttendanceModel attendanceModel) {
        return attendanceRepository.save(attendanceModel);
    }

    public List<AttendanceModel> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public AttendanceModel getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    public AttendanceModel updateAttendance(Long id, AttendanceModel updatedAttendanceModel) {
        AttendanceModel existingAttendanceModel = attendanceRepository.findById(id).orElse(null);
        if (existingAttendanceModel != null) {
            // Update the existing record with the new data
            existingAttendanceModel.setName(updatedAttendanceModel.getName());
            existingAttendanceModel.setEmail(updatedAttendanceModel.getEmail());
            // Update other fields as needed

            // Save the updated record
            return attendanceRepository.save(existingAttendanceModel);
        } else {
            return null; // Return null if the record with the given ID is not found
        }
    }

    // Method to delete an attendance record by ID
    public boolean deleteAttendance(Long id) {
        AttendanceModel existingAttendanceModel = attendanceRepository.findById(id).orElse(null);
        if (existingAttendanceModel != null) {
            attendanceRepository.deleteById(id);
            return true;
        } else {
            return false; // Return false if the record with the given ID is not found
        }
    }
}

using System;
using System.Collections.Generic;

namespace CompCheck.Models
{
    public class Pet
    {
        public int PetId { get; set; }
        public string PetName { get; set; }
        public string PetType { get; set; }
        public string Breed { get; set; }
        public string DateOfBirth { get; set; }
        public string Gender { get; set; }
        public string ChipNo { get; set; }
        public string OwnerName { get; set; }

        public Pet(int petId, string petName, string petType, string breed, string dateOfBirth, string gender, string chipNo, string ownerName)
        {
            PetId = petId;
            PetName = petName;
            PetType = petType;
            Breed = breed;
            DateOfBirth = dateOfBirth;
            Gender = gender;
            ChipNo = chipNo;
            OwnerName = ownerName;
        }

        public static Pet FromDict(Dictionary<string, object> dict)
        {
            if (dict == null || dict.Count == 0) return null;

            return new Pet(
                Convert.ToInt32(dict["pet_id"]),
                dict["pet_name"]?.ToString(),
                dict["pet_type"]?.ToString(),
                dict["breed"]?.ToString(),
                dict["date_of_birth"]?.ToString().Trim(new char[] { ' ' }),
                dict["gender"]?.ToString(),
                dict["chip_no"]?.ToString(),
                dict["owner_name"]?.ToString()
                );
        }

        public override string ToString()
        {
            return $"Pet ID: {PetId}\nPet Name: {PetName}\nPet Type{PetType}\nBreed: {Breed}\nD.O.B: {DateOfBirth}\nGender: {Gender}\nChip Number: {ChipNo}n\nOwner: {OwnerName}";
        }
    }
}

using CompCheck.Models;
using System.Collections.Generic;
using System.Threading.Tasks;

namespace CompCheck.Interfaces
{
    public interface IDataService
    {
        Task<IEnumerable<Pet>> GetAllPetsAsync();
        Task<IEnumerable<Vet>> GetVetAverageAsync();
        Task<IEnumerable<TreatmentModel>> GetAllPetTreatmentsAsync(int petId);
    }
}

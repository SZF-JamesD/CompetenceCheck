using CompCheck.Interfaces;
using CompCheck.Models;
using CompCheck.Views;
using Microsoft.Extensions.DependencyInjection;
using MvvmUtilities;
using MvvmUtilities.Interfaces;
using System;
using System.Collections.ObjectModel;
using System.Windows.Input;

namespace CompCheck.ViewModels
{
    public class MainViewModel : ViewModelBase
    {
        public ICommand ToTreatmentDetailsCommand { get; }
        public ICommand RefreshCommand { get; }

        public ObservableCollection<Pet> Pets { get; set; }
        public ObservableCollection<Vet> Vets { get; set; }


        private Pet _selectedPet;
        public Pet SelectedPet
        {
            get { return _selectedPet; }
            set
            {
                SetProperty(ref _selectedPet, value);
            }
        }

        private readonly IDataService _dataService;
        private readonly IDialogService _dialogService;

        public MainViewModel(IDataService dataService, IDialogService dialogService)
        {
            _dataService = dataService;
            _dialogService = dialogService;
            Pets = new ObservableCollection<Pet>();
            Vets = new ObservableCollection<Vet>();

            ToTreatmentDetailsCommand = new RelayCommand(OnPetDoubleClick);
            RefreshCommand = new RelayCommand(Refresh);

            LoadPets();
            LoadVets();
        }

        private async void LoadPets()
        {
            try
            {
                var petList = await _dataService.GetAllPetsAsync();
                Pets.Clear();
                foreach (var pet in petList)
                {
                    Pets.Add(pet);
                }
            }
            catch (Exception ex)
            {
                _dialogService.ShowError("Error loading pets: " + ex.Message);
            }
        }

        private async void LoadVets()
        {
            try
            {
                var vetList = await _dataService.GetVetAverageAsync();
                Vets.Clear();
                foreach (var vet in vetList)
                {
                    Vets.Add(vet);
                }
            }
            catch (Exception ex)
            {
                _dialogService.ShowError("Error loading vets: " + ex.Message);
            }
        }

        private async void OnPetDoubleClick()
        {
            if (SelectedPet != null)
            {
                var detailView = App.ServiceProvider.GetRequiredService<TreatmentDetailView>();
                if (detailView.DataContext is TreatmentDetailViewModel vm)
                {
                    await vm.LoadTreatmentsForPet(SelectedPet.PetId);
                    
                    detailView.Show();
                }
                else
                {
                    _dialogService.ShowError("You must select a pet to  view details", "No Selection");
                }
            }
        }
    
        public  void Refresh()
        {
            LoadPets();
            LoadVets();
        }
    }
}

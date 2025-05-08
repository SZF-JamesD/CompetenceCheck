using CompCheck.ViewModels;
using Microsoft.Extensions.DependencyInjection;
using System.Windows;

namespace CompCheck.Views
{
    public partial class TreatmentDetailView : Window
    {
        public TreatmentDetailView()
        {
            InitializeComponent();
            var vm = App.ServiceProvider.GetRequiredService<TreatmentDetailViewModel>();
            DataContext = vm;
        }
    }
}

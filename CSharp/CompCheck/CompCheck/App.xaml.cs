using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Threading.Tasks;
using System.Windows;
using MySql.Data.MySqlClient;
using Microsoft.Extensions.DependencyInjection;
using System.Data.Common;
using DBLib;
using MvvmUtilities.Interfaces;
using MvvmUtilities;
using System.Collections.ObjectModel;
using CompCheck.Interfaces;
using CompCheck.Services;
using CompCheck.ViewModels;
using CompCheck.Models;
using CompCheck.Views;

namespace CompCheck
{
    public partial class App : Application
    {

        public static IServiceProvider ServiceProvider { get; private set; }

        protected override void OnStartup(StartupEventArgs e)
        {
            var serviceCollection = new ServiceCollection();

            ConfigureServices(serviceCollection);

            ServiceProvider = serviceCollection.BuildServiceProvider();

            var mainWindowViewModel = ServiceProvider.GetRequiredService<MainWindowViewModel>();
            var mainWindow = ServiceProvider.GetRequiredService<MainWindow>();

            mainWindow.DataContext = mainWindowViewModel;
            mainWindow.Show();

            base.OnStartup(e);
        }

        public void ConfigureServices(IServiceCollection services)
        {
            services.AddTransient<Func<DbConnection>>(_ => () => DBConnection.GetConnection());
            services.AddTransient<DBService>();

            services.AddSingleton<IDialogService, DialogService>();
            services.AddSingleton<IDataService, DataService>();

            services.AddSingleton<ObservableCollection<Pet>>();
            services.AddSingleton<ObservableCollection<Vet>>();
            services.AddSingleton<ObservableCollection<TreatmentModel>>();

            services.AddSingleton<MainWindowViewModel>();
            services.AddSingleton<MainViewModel>();
            services.AddTransient<TreatmentDetailViewModel>();

            services.AddSingleton<MainWindow>();
            services.AddSingleton<MainView>();
            services.AddTransient<TreatmentDetailView>();
        }

    
    }
       
    
}

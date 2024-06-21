import SwiftUI
import shared

struct ContentView: View {
    
    @State private var shoulOpenAbout = false
    
    var body: some View {
        
        NavigationStack{
            ArticlesScreen(viewModel: .init())
                .toolbar{
                    ToolbarItem{
                        Button{
                            shoulOpenAbout = true
                        } label: {
                            Label("About", systemImage: "info.circle").labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shoulOpenAbout){
                            AboutScreen()
                        }
                    }
                }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

//
//  ContentView.swift
//  iOS
//
//  Created by Financial CB on 2023/07/11.
//

import SwiftUI

struct ContentView: View {
    var body: some View {
        VStack {
            HeaderView()
            CustomTopTabBar()
            Spacer()
        }
        .padding(16)
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

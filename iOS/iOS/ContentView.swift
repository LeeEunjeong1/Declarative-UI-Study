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
				.padding(.init(top: 16, leading: 16, bottom: 0, trailing: 16))
			Spacer()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
